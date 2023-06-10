onload = () => {
  $('#headerUsername').text($util.getItem('userInfo'))
  $('#headerDivB').text('用户管理')
  fetchUserList()
}

let pageNum = 1
let userList = []

const fetchUserList = () => {
  let curUser=$util.getItem('userInfo')
  let params={}
  if(curUser==='admin'){
     params = {
      pageNum,
      pageSize: 10,
      username :$("#username").val(),//:$('userName').val(),//: //$('#headerUsername').val()
    }
  }else{
     params = {
      pageNum,
      pageSize: 10,
      username :curUser
          //$("#username").val(),//:$('userName').val(),//: //$('#headerUsername').val()
    }

  }

  // let params = {
  //   pageNum,
  //   pageSize: 10,
  //   username :$("#username").val(),//:$('userName').val(),//: //$('#headerUsername').val()
  // }
  $.ajax({
    url: API_BASE_URL + '/admin/queryUserList',
    type: 'POST',
    data: JSON.stringify(params),
    dataType: 'json',
    contentType: 'application/json',
    success(res) {
      $('#table #tbody').html('')
      userList = res.data
      res.data.map((item, index) => {//集合遍历
        $('#table #tbody').append(`
          <tr>
            <td>${index + 1}</td>
            <td>${item.username}</td>
            <td>${item.password}</td>
            <td>${item.startTime}</td>
            <td>${item.endTime}</td>
            <td>            
              <button type="button" class="btn btn-link" onclick="handleEdit('${item.id}')">编辑账户信息</button>
              <button type="button" class="btn btn-link btn-red" onclick="handleExit('${item.id}')">关闭</button>
              <button type="button" class="btn btn-link btn-red" onclick="deleteUser('${item.id}')">删除</button>
            </td>
          </tr>
        `)
      })
    }
  })
}
//<button type="button" className="btn btn-link">重置密码</button>
const deleteUser = (id)=>{
    let params={}
    let state = confirm("确认删除该用户吗？")
    if (state) {
        params = {
            id: id
        }
    }
    $.ajax({
         url: API_BASE_URL +'/admin/deleteUserById',
         type:'DELETE',
         data:JSON.stringify(params),
         dataType: 'json',
         contentType: 'application/json',
         success(res){
           fetchUserList()
         },
         err:{

         }
    })
}
const handleTableChange = (page) => {
  if (page === 1) {
    if (pageNum === 1) return
    pageNum--
  } else if (page === 2) {
    pageNum++
  } else if (page === 3) {
    pageNum = +$('#goNum').val()
  }
  $('#currentPage').text(pageNum)
  fetchUserList()
}

const handleCreateUser = () => {
  $util.setPageParam('user', undefined)
  location.href = '/pages/createUser/index.html'
}

const handleEdit = (id) => {
  let user = userList.filter(item => item.id === id)[0]
  console.log(user);
  $util.setPageParam('user', user)
  location.href = '/pages/editUser/index.html'
}

const handleExit = (id) => {
    let params={}
    let state = confirm("确认关闭该用户吗？")
    if (state) {
        params = {
            id: id
        }
    }
    $.ajax({
        url: API_BASE_URL +'/admin/closeUserById',
        type:'POST',
        data:JSON.stringify(params),
        dataType: 'json',
        contentType: 'application/json',
        success(res){
            alert("关闭用户成功")
            fetchUserList()
        },
        err:{

        }
    })
}