onload = () => {
  $('#headerUsername').text($util.getItem('userInfo'))
  $('#headerDivB').text('创建问卷！')
  // let test = $util.getPageParam('createQuestionnaire')
  let test = `${$util.getPageParam('createQuestionnaire')}`
  let projectId=$util.getPageParam('seeProject')

  console.log(test)
  console.log("???")
  fetchProjectList(test)
}

const onCreateTemplate = () => {

  location.href = "/pages/createNewQuestionnaire/index.html"
}

const fetchProjectList = ( test) => {
  let params = {
    createdBy: $util.getItem('userInfo').username,
    projectName: $('#projectName').val()
  }
  $.ajax({
    url: API_BASE_URL + '/queryProjectList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      projectList = res.data
      // for(int i = 0; i < res.data.length; i++);
      // for(let item : res.data);
      // res.data.foreach(item => {
      //
      // })
      // $('#selectLeo').append(`
      //
      //       <option value=i selected>${item.projectName}</option> i++
      //   `)
      let i=1
      res.data.map(item => {
        console.log(item.projectName)

        if( test== item.projectName


        ){
          $('#selectLeo').append(`
            <option value=i selected>${item.projectName}</option>
        `)
          console.log('找到了')
          //system.out.printlen("找到了")
          i++
        }
        else{
          $('#selectLeo').append(`
            <option value=i >${item.projectName}</option>
        `)
          console.log('没找到')
          i++
        }
      })
    }
  })
}
const importHistoryQuestionnaire = () => {
  $('#divider').css('display', 'flex')
  $('#templateB').html('')
  $('#templateB').append(`
    <div class="template-item">
      <div class="item-t">
        <img class="img" src="../../static/images/blank_template.png">
        <div>
          <div class="title">测试</div>
          <div>页面测试数据</div>
        </div>
      </div>
      <div class="item-b">
        <button type="button" class="btn btn-default">导 入</button>
      </div>
    </div>
  `)
}

const surveyTypeTemplate = () => {
  $('#divider').css('display', 'flex')
  $('#templateB').html('')
  $('#templateB').append(`
    <div class="template-item">
      <div class="item-t">
        <img class="img" src="../../static/images/blank_template.png">
        <div>
          <div class="title">创建模板</div>
          <div>题库抽题，限时作答，成绩查询，自动阅卷</div>
        </div>
      </div>
      <div class="item-b">
        <button type="button" class="btn btn-default" onclick="createTemplate()">创 建</button>
      </div>
    </div>
    <div class="template-item">
      <div class="item-t">
        <img class="img" src="../../static/images/blank_template.png">
        <div>
          <div class="title">测试</div>
          <div></div>
        </div>
      </div>
      <div class="item-b">
        <button type="button" class="btn btn-default" onclick="handleEdit()" style="margin-right: 10px;">编 辑</button>
        <button type="button" class="btn btn-default">导 入</button>
      </div>
    </div>
  `)
}

const createTemplate = () => {
  $('#createTemplateModal').modal('show')
}

const handleEdit = () => {
  open('/pages/designQuestionnaire/index.html')
}
