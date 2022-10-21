/**
* 基础菜单 商品管理
*/
<template>
  <div>
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>讨论管理</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 搜索筛选 -->
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="搜索：">
        <el-input size="small" v-model="formInline.title" placeholder="请输入博客标题"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()">添加</el-button>
      </el-form-item>
    </el-form>
    <!--列表-->
    <el-table size="small" :data="blogs" highlight-current-row style="width: 100%;">
      <el-table-column align="center" type="selection" width="60">
      </el-table-column>
      <el-table-column sortable prop="id" label="序号" v-if="false"></el-table-column>
      <el-table-column sortable prop="title"  label="标题" width="300">
      </el-table-column>
      <el-table-column sortable prop="description" label="摘要" width="480">
      </el-table-column>
      <el-table-column sortable prop="created"  value-format="timestamp" label="更新时间" width="100">
      </el-table-column>
      <el-table-column align="center" label="操作" min-width="300">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteBlog(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
    <!-- 编辑界面 -->
    <el-dialog :title="titleForm" :visible.sync="editFormVisible" width="60%" @click="closeDialog">
      <el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
        <el-form-item label="标题" prop="title">
          <el-input size="small" v-model="editForm.title" auto-complete="off" placeholder="请输入博客标题"></el-input>
        </el-form-item>
        <el-form-item label="摘要" prop="description">
          <el-input size="small" v-model="editForm.description" auto-complete="off" placeholder="请输入摘要"></el-input>
        </el-form-item>
        <el-form-item label="内容" prop="content">
          <mavon-editor v-model="editForm.content"></mavon-editor>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="medium" @click="resetForm('editForm')" type="info">重置</el-button>
        <el-button size="medium" @click="closeDialog">取消</el-button>
        <el-button size="medium" type="primary" class="title" @click="closeDialogAndsubmit()">保存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import Pagination from '../../components/Pagination'
import {getToken} from "../../api/auth";
export default {
  name: "Discusses"
  ,
  data() {
    return {
      nshow: true, //switch开启
      fshow: false, //switch关闭
      isLoad: true, //是显示加载
      editFormVisible: false, //控制编辑页面显示与隐藏
      addTest:false,
      titleForm: '添加',
      editForm:{
        id:'',
        userId: '',
        title: '',
        description: '',
        content: '',
        created:'',
      },
      // rules表单验证
      rules: {
        deptName: [
          { required: true, message: '请输入部门名称', trigger: 'blur' }
        ],
        deptNo: [{ required: true, message: '请输入部门代码', trigger: 'blur' }]
      },
      formInline: {
        currentPage: 1,
        pageSize: 10,
        title: '',
        description: '',
        token: localStorage.getItem('login-token')
      },
      // 删除部门
      seletedata: {
        ids: '',
        token: localStorage.getItem('login-token')
      },
      userparm: [], //搜索权限
      blogs: [], //博客数据
      // 分页参数
      pageparm: {
        currentPage: 1,
        pageSize: 10,
        total: 10
      }
    }
  },
  // 注册组件
  components: {
    Pagination
  },
  created() {
    this.getBlogs(this.formInline)
    if (getToken()===null){
      this.$router.push("/")
    }
  },
  methods: {
    //对话框测试
    addTestHanlder(){
      this.addTest = true
    },
    //重置编辑
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //获取博客列表
    getBlogs(parameter) {
      this.loading = true
      this.$http.get("/article", {params:parameter})
          .then(res => {
            this.blogs=[]
            for (let i in res.data.data.content){
              this.blogs.push(res.data.data.content[i])
            }
            // 分页赋值
            this.pageparm.currentPage = this.formInline.currentPage
            this.pageparm.pageSize = this.formInline.pageSize
            this.pageparm.total = res.data.total
          })
          .catch(err => {
            this.loading = false
            this.$message.error('菜单加载失败，请稍后再试！')
          })
    },
    // 分页插件事件
    callFather(parm) {
      this.formInline.currentPage = parm.currentPage
      this.formInline.pageSize = parm.pageSize
      this.getBlogs(this.formInline)
    },
    // 搜索事件
    search() {
      this.loading = true
      this.blogs = []
      this.$http.get("/articleLike",{params: this.formInline}).then((res) =>{
        for (let i in res.data.data) {
          this.blogs.push(res.data.data[i]);
        }
        // 分页赋值
        //this.pageparm.currentPage = this.formInline.page
        //this.pageparm.pageSize = this.formInline.limit
        this.pageparm.total = res.data.total
      })
    },
    //显示编辑界面
    handleEdit: function(index, row) {
      this.editFormVisible = true
      if (row !== undefined && row !== 'undefined') {
        this.title = '修改'
        this.editForm.id = row.id
        this.editForm.title = row.title
        this.editForm.description = row.description
        this.editForm.content = row.content
      } else {
        this.title = '添加'
        this.editForm.title = ''
        this.editForm.description = ''
        this.editForm.content = ''
      }
    },
    //更新,新增博客
    submitForm(editData) {
      this.$refs[editData].validate(valid => {
        if (valid) {
          let blog ={
            id: this.editForm.id,
            userId:null,
            title: this.editForm.title,
            description: this.editForm.description,
            content: this.editForm.content,
            created: new Date()
          }
          console.log(blog);
          this.$http.post("article",this.$qs.parse(blog))
              .then(res => {
                this.editFormVisible = false
                if (res.data.code===200) {
                  this.getBlogs(this.formInline)
                  this.$message({
                    type: 'success',
                    message: res.data.msg
                  })
                } else {
                  this.$message({
                    type: 'success',
                    message: res.data.msg
                  })
                }
              })
              .catch(err => {
                this.editFormVisible = false
                this.loading = false
                this.$message.error('博客保存失败，请稍后再试！')
              })
        } else {
          return false
        }
      })
    },
    // 删除博客
    deleteBlog(index, row) {
      this.$confirm('确定要删除吗?', '信息', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.delete("/article/"+row.id).then(res => {
          if (res.data.code === 200) {
            //刷新列表
            this.getBlogs(this.formInline)
            this.$message({
              type: 'success',
              message: '博客已经删除!'
            })
          }
          else {
            this.$message({
              type: 'info',
              message: res.data.msg,
            })
          }
        }).catch(err => {
          this.loading = false
          this.$message.error('博客删除失败，请稍后再试！')
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    // 关闭编辑、增加弹出框
    closeDialog() {
      this.editFormVisible = false
    },
    closeDialogAndsubmit(){
      this.editFormVisible = false
      this.submitForm('editForm')
    }
  }
}
</script>

<style scoped>
.user-search {
  margin-top: 20px;
}
.userRole {
  width: 100%;
}
</style>


