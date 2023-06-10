onload = () => {
  $('#headerUsername').text($util.getItem('userInfo'))
  $('#headerDivB').text('创建调查问卷')
  // let test = `${$util.getPageParam('createQuestionnaire')}`
  // let projectId=$util.getPageParam('seeProject')
  console.log('项目名称为：')
  //console.log(test)
  //console.log($('#headerUsername'))
  $('#startTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd', // 显示格式
    minView: "month", // 设置只显示到月份
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
  // $('#startTime').on('changeDate', function(e) {
  //   // 获取选中的日期
  //   var selectedDate = e.date;
  //   $('#startTime').val(selectedDate);
  //   // 更新params.startTime的值
  // })
  $('#endTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd', // 显示格式
    minView: "month", // 设置只显示到月份
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
  // $('#endTime').on('changeDate', function(e) {
  //   // 获取选中的日期
  //   var selectedDate = e.date;
  //   $('#endTime').val(selectedDate);
  // })

}
const handleCreateQuestionnaire = (
) => {
  //console.log($('#startTime').val())
  // let startTime = new Date(`${startTime}`);
  // let endTime = new Date(`${endTime}`);
  let startTimeValue = $('#startTime').datetimepicker('getDate');
  console.log('ceshi');
  let test = `${$util.getPageParam('createQuestionnaire')}`
  let projectId=$util.getPageParam('seeProject')
  let curUserID=$util.getItem('curUserID')
  let randomString = generateRandomString(28)
  console.log(randomString)
  //console.log(test);
 // let projectName=test;

  let params = {
    id :randomString,
    projectName: projectId,
    userId:curUserID,
    createdBy: $util.getItem('userInfo'),
    lastUpdatedBy: $util.getItem('userInfo'),
    questionnaireName: $('#surveyName').val(),
    questionnaireContent: $('#surveyDescription').val(),
    startTime: $('#startTime').datetimepicker('getDate'),
    endTime: $('#endTime').datetimepicker('getDate')

  }
  console.log(params.startTime)
  console.log('12234556')
  console.log(params.endTime)
  console.log('12234556')
  //let API_BASE_URL='127.0.0.1:8085'
  if (!params.questionnaireName) return alert('问卷名称不能为空！')
  if (!params.questionnaireContent) return alert('问卷描述不能为空！')
  if (!$('#startDate').val() ) return alert('开始时间不能为空！')
  if (!$('#endDate').val() ) return alert('结束时间不能为空！')

  $.ajax({
    url:API_BASE_URL + '/addQuestionnaireInfo',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success() {
      $util.setItem('QuestionnaireID',randomString)
      onDesignQuestionnaire()
      //alert('创建成功！')
    }
  })
  const onDesignQuestionnaire = () => {
    location.href = "/pages/designQuestionnaire/index.html"
  }
  function generateRandomString(length) {
    let result = '';
    let characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let charactersLength = characters.length;
    for (let i = 0; i < length; i++) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
  }
}
