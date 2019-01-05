var wangEditor=function () {
    var E = window.wangEditor;
   var InithandlerInitWangEditor=function (editorId,Textid) {
       var editor = new E('#' + editorId);
       editor.customConfig.uploadImgServer = '/upload';
       editor.customConfig.uploadFileName = 'editorFiles';
       editor.customConfig.onchange = function (html) {
           $("#" + Textid).val(html);
       };
       editor.create();
       $("#" + Textid).val(editor.txt.html());
   }

    return{
        initWangEditor:function (editorId,Textid) {
            InithandlerInitWangEditor(editorId,Textid);
        }
    }
}()