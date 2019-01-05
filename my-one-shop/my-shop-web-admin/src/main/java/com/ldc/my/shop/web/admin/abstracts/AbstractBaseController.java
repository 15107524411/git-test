package com.ldc.my.shop.web.admin.abstracts;

import com.ldc.my.shop.web.admin.commons.BeanValidator;
import com.ldc.my.shop.web.admin.commons.PageInfo;
import com.ldc.my.shop.web.admin.constants.SystemConstants;
import com.ldc.my.shop.web.admin.dto.DataTable;
import com.ldc.my.shop.web.admin.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;

/**
 * 控制器基类
 * <p>Title: AbstractBaseController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/30 10:56
 */
public abstract class AbstractBaseController<T extends AbstractBaseEntity ,S extends BaseCrudService<T>> {

    @Autowired
    protected S service;
    /**
     * 会优先执行，并返回数据
     * @param id
     * @return
     */
    @ModelAttribute
    public T getById(Long id) throws IllegalAccessException, InstantiationException {
        if (id == null) {
            ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class clazz = (Class<T>) ptype.getActualTypeArguments()[0];
            T o = (T) clazz.newInstance();
            return o;
        } else {
            return service.getById(id);
        }
    }


    @ResponseBody
    @PostMapping(value = "page")
    public DataTable<T> page(T entity, HttpServletRequest request) {
        DataTable<T> dataTable = new DataTable<>();

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        String iDisplayStart = request.getParameter("iDisplayStart");
        System.out.println(iDisplayStart);

        int draw = StringUtils.isBlank(strDraw) ? 1 : Integer.parseInt(strDraw);
        int start = StringUtils.isBlank(strStart) ? 0 : Integer.parseInt(strStart);
        int length = StringUtils.isBlank(strLength) ? 10 : Integer.parseInt(strLength);

        PageInfo<T> pageInfo = service.page(entity, start, length);
        dataTable.setDraw(draw);
        dataTable.setRecordsTotal(pageInfo.getTotal());
        dataTable.setRecordsFiltered(pageInfo.getTotal());
        dataTable.setData(pageInfo.getData());

        return dataTable;
    }


    protected boolean beanValidator(T entity, Model model) {
        return checkBeanValidator(entity, model);
    }

    protected boolean beanValidator(T entity, RedirectAttributes redirectAttributes) {
        return checkBeanValidator(entity, redirectAttributes);
    }

    protected void addMessage(Model model, String message) {
        model.addAttribute(SystemConstants.MESSAGE, message);
    }

    protected void addMessage(RedirectAttributes redirectAttributes, String message) {
        redirectAttributes.addFlashAttribute(SystemConstants.MESSAGE, message);
    }

    /**
     * 检查 Bean
     */
    private boolean checkBeanValidator(T entity, Model model) {
        String result = BeanValidator.validator(entity);
        // 验证失败
        if (StringUtils.isNoneBlank(result)) {
            if (model instanceof RedirectAttributes) {
                RedirectAttributes redirectAttributes = (RedirectAttributes) model;
                addMessage(redirectAttributes, result);
            } else {
                addMessage(model, result);
            }
            return false;
        }

        // 验证成功
        else {
            return true;
        }
    }
}
