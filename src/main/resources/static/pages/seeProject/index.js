onload = () => {
  $('#headerUsername').text($util.getItem('userInfo'))
  $('#headerDivB').text('项目详情')

  let projectId = $util.getPageParam('seeProject')
  console.log(projectId, 'projectId')
  fetchProjectInfo(projectId)
  fetchQuestionInfo(projectId)
}

const fetchProjectInfo = (id) => {
  let params = {
    id
  }
  $.ajax({
    url: API_BASE_URL + '/queryProjectList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let info = res.data[0]
      console.log(info, 'res')
      $('#projectName').text(info.projectName)
      $('#createTime').text(info.creationDate)
      $('#personInCharge').text(info.createdBy)
      $('#projectDescription').text(info.projectContent)
    }
  })
}
const fetchQuestionInfo = (projectName ) => {
  let params = {
    projectName
  }
  $.ajax({
    url: API_BASE_URL + '/queryQuestionnaireList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let show=res;
      console.log(show)
      // let table = document.getElementById('myTable');
      // let tbody = table.getElementsByTagName('tbody');
      //var tableBody = document.getElementById("tableBody");
      let str ="";

      // 遍历数据并创建表格行
      for(let i=0;i<res.data.length;i++) {
        let tmp=res.data[i].id;
        let str1="onclick="+`"onRelease('`+tmp+"')";
        let str2="onclick="+`"showPopup('`+tmp;
        //onclick="onSeeProject("tmp") ";
        //`<button type="button" className="btn btn-link" "onclick="+`"onRelease(' `+res.data[i].id+`')>发布</button>`
        str="<tr><td>"+res.data[i].id+"</td><td>"+res.data[i].questionnaireName+"</td><td>"+res.data[i].startTime+
            `<td>`+
               `<button type="button" className="btn btn-link" onclick= "onRelease('`+(res.data[i].id)+`')">发布</button>`+
               `<button type="button" className="btn btn-link">关闭</button>`+
               `<button type="button" className="btn btn-link" onclick= "showPopup('`+(res.data[i].id)+`')">链接</button>` +
               `<button type="button" className="btn btn-link" onclick= "showPopup2('`+(res.data[i].id)+`')">统计</button>` +`
              </td>
            "</td></tr>"`
        $("#tableBody").append($(str))

      }

    }
  })
}

const onRelease =(id)=>{
  console.log("test")
  console.log(id)
  let params = {
    id:id
  }
  $.ajax({
    url: API_BASE_URL + '/releaseQuestionnaire',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      console.log("发布成功！")
    }
  })

}
function showPopup(id){
  let url=API_BASE_URL+'/answer/'+id
  $("#addr").text(url);
  let overlay = document.getElementById("overlay");
  overlay.style.display = "block";
}
function showPopup2(id){
  let params={
    surveyId:id
  }
  let result=`-----------------`+id+`问卷答题情况:------------------`
  let question=[];
  $.ajax({
    url: API_BASE_URL + '/queryQuestionList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let len = res.data.length;
      for (let i = 0; i < len; i++) {
        question[i] = {};
        question[i].questionId=res.data[i].questionId;
        question[i].questionText=res.data[i].questionText;
        question[i].options = [];
      }
      $.ajax({
        url: API_BASE_URL + '/queryOptionList',
        type: "POST",
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        success(res) {
          console.log(res);
          let len = res.data.length;
          for (let i = 0; i < len; i++) {
            let option = res.data[i];
            //console.log(option.questionId-1)
            question[option.questionId - 1].options[option.optionId - 1] = {};
            question[option.questionId - 1].options[option.optionId - 1].optionContent = res.data[i].optionContent;
            question[option.questionId - 1].options[option.optionId - 1].optionId=res.data[i].optionId;
            question[option.questionId - 1].options[option.optionId - 1].number=res.data[i].number;
          }
          console.log(question);
          for(let i=0;i<question.length;i++){
            let tmp= `题号: ` +i + '题目内容:'+ question[i].questionText+ `<br>`
            let ops=question[i].options;
            for(let j=0;j<ops.length;j++){
              tmp=tmp+
                  "题目选项："+ops[j].optionContent+'  数量 ：'+ops[j].number+'<br>'

            }
            result=result+tmp;
          }
          console.log(result)
          $("#result").html(result);
          let overlay2 = document.getElementById("overlay2");
          overlay2.style.display = "block";
        }

      })
    }
  })

  //$("#result").text(result);

}
function hidePopup(){
  let overlay = document.getElementById("overlay");
  overlay.style.display = "none";
}
function hidePopup2(){
  let overlay2 = document.getElementById("overlay2");
  overlay2.style.display = "none";
}
