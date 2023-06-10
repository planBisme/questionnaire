let project = {}

onload = () => {
  $('#headerUsername').text($util.getItem('userInfo'))
  $('#headerDivB').text('编辑项目')

  project = $util.getPageParam('editProject')

  $('#projectName').val(project.projectName)
  $('#projectDescribe').val(project.projectContent)
}

const handleSaveChange = () => {
  let params = {
    id: project.id,
    projectName: $('#projectName').val(),
    projectContent: $('#projectDescribe').val(),
    lastUpdatedBy:$util.getItem('userInfo'),
    lastUpdateDate: new Date(),
  }
  if (!params.projectName) return alert('项目名称不能为空！')
  if (!params.projectContent) return alert('项目描述不能为空！')
  $.ajax({
    url: API_BASE_URL + '/modifyProjectInfo',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      alert("修改项目信息成功")
      location.href = "/pages/questionnaire/index.html"
    }
  })
}
