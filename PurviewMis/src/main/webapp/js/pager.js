doPager = function (toPageIndex) {
    $('#form1').attr('action', '<%= request.getContextPath() %>' +  pageListUrl+'?pageIndex='+toPageIndex);
    $('#form1').submit();
}