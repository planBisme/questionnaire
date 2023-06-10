const problemList=[]
let flag=0
let names=[]
onload = () => {
  const urlParams = new URLSearchParams(window.location.search);
  const encodedArray = urlParams.get('data');
  const decodedArray = JSON.parse(decodeURIComponent(encodedArray));
  //const decodedArray=$util.getPageParam('problem')
  console.log(decodedArray);
  const idValue = getURLParameter('id');
  console.log(idValue);
  if(idValue!=null){
      fetchQuestionList(idValue);
      console.log(problemList.length);
      flag=1;
  }
  if(decodedArray!=null){
      decodedArray.forEach((question,index)=>{
          const questionTemplate=`
    <div class="question" id="question${index+1}" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title">${question.problemName}</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        ${question.option.map(option => `
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="radio-inline">
              <input type="radio" name="chooseTerm"  id=`+123 +`> ${option.chooseTerm}
            </label>
          </div>
        `).join('')}
      </div>
    </div>
    `;
          $('#problem').append(questionTemplate)
      })

  }

}
const onSubmit = () => {
    if(flag==0){
        return alert('预览状态，无法提交！')
    }
    console.log(problemList)
    console.log('names:--------------------------')
    console.log(names)
    let optionSubmit=[];

     for(let i=0;i<problemList.length;i++){
         optionSubmit[i]={};
         optionSubmit[i].surveyId=problemList[i].surveyId;
         optionSubmit[i].questionId=problemList[i].questionId+1;
     }
    // $("input[name='sex']:checked").val();
    //"input[name='uoqL0T04KwBwbcmR5AHfpTeOYiS30']:checked"
    //input[name='uoqL0T04KwBwbcmR5AHfpTeOYiS30']:checked
     for(let i=0;i<names.length;i++){
         let tmp=names[i];
         let test=$("input[name='"+ tmp+"']:checked").val();
         optionSubmit[i].optionId=Number(test);
     }
    //document.getElementsById('chooseTerm')
    //let option = document.querySelector('input[name="option2"]').checked
   // option.questionId+option.questionId+option.optionContent
  console.log(optionSubmit);
    $.ajax({
        url: API_BASE_URL + '/submitQuestionnaire',
        //'http://127.0.0.1:8085'
        type: "POST",
        data: JSON.stringify(optionSubmit),
        dataType: "json",
        contentType: "application/json",
        success(res) {
            console.log('数据库更新成功')
        }
    })
  console.log("提交成功！");


   window.open("/pages/questionnaire/index.html")
  //window.open('/pages/designQuestionnaire/index.html');
}
const onExit = () => {
    //console.log("传值成功！");
    window.open("/pages/questionnaire/index.html")
    //window.open('/pages/designQuestionnaire/index.html');
}
function getURLParameter(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}
function fetchQuestionList(idValue) {
    let params = {
        surveyId: idValue
    }
    $.ajax({
        url: API_BASE_URL + '/queryQuestionList',
        //'http://127.0.0.1:8085'
        type: "POST",
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        success(res) {
            let len = res.data.length;
            for (let i = 0; i < len; i++) {
                problemList[i] = {};
                problemList[i].surveyId=res.data[i].surveyId;
                problemList[i].questionId = res.data[i].questionId - 1;
                problemList[i].questionText = res.data[i].questionText;
                problemList[i].questionType = res.data[i].questionType;
                problemList[i].options = [];
            }
        }
    })
    $.ajax({
        url: API_BASE_URL + '/queryOptionList',
        //'http://127.0.0.1:8085'
        type: "POST",
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        success(res) {
            console.log(res);
            let len = res.data.length;
            let surveyId=res.data[0].surveyId
            for (let i = 0; i < len; i++) {
                let option = res.data[i];
                //console.log(option.questionId-1)
                problemList[option.questionId - 1].options[option.optionId - 1] = {};
                problemList[option.questionId - 1].options[option.optionId - 1].optionContent = res.data[i].optionContent;
                problemList[option.questionId - 1].options[option.optionId - 1].optionId=res.data[i].optionId;
            }
            console.log(problemList);

            problemList.forEach((question, index) => {
                let options=question.options
                let name=''+surveyId+question.questionId
                names[index]=name
                console.log(options)
                let str=''
                for(let i=0;i<options.length;i++){
                    let option=options[i]
                    let ss=`
                     <div style="display: flex; align-items: center; margin-bottom: 3px;">
                     <label class="radio-inline">
                     <input type="radio" name="`+name +
                        `"  value="${option.optionId}"> ${option.optionContent}
                     </label>
                     </div>`
                    str=str+ss;
                }
                console.log(str)

                const questionTemplate = `
               <div class="question" id="question${index + 1}" data-type="1" data-problemIndex="1">
                   <div class="top">
                   <span class="question-title">${question.questionText}</span>
                   <span class="must-answer" id="mustAnswer">必答题</span>
               </div>
               <div class="bottom">
               `+str+`
              
    </div>
    `;
                $('#problem').append(questionTemplate)
            })

        }

    })

}

// ${question.options.map(option => `
//   <div style="display: flex; align-items: center; margin-bottom: 3px;">
//     <label class="radio-inline">
//       <input type="radio" name="chooseTerm`+ option.questionId+option.questionId+option.optionContent +`" > ${option.optionContent}
// </label>
// </div>
// `).join('')}

