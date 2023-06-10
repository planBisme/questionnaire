function export_excel() {
    //选择表格
    var table = $('#formTable');
    //判断表格是否存在且不为空表格
    if (table && table.length) {
        $(table).table2excel({
            exclude: ".hidden_input", // 不导出的class
            filename: "人员信息.xls", // 导出的文件名
            fileext: ".xls", // 文件类型
            exclude_img: true, // 是否导出图片
            exclude_links: false, // 是否导出超链接
            exclude_inputs: true, // 是否导出输入框中的内容
            preserveColors: false // 是否导出背景颜色
        });
    }
}