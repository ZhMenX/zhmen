/**
* 基础菜单 商品管理
*/
<template>
  <div>
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>文章管理</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 搜索筛选 -->
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="搜索：">
        <el-input size="small" v-model="formInline.title" placeholder="请输入博客标题"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input size="small" v-model="formInline.description" placeholder="请输入博客摘要"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()">添加</el-button>
      </el-form-item>
    </el-form>
    <!--列表-->
    <el-table size="small" :data="blogs" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中" style="width: 100%;">
      <el-table-column align="center" type="selection" width="60">
      </el-table-column>
      <el-table-column sortable prop="title" label="标题" width="300">
      </el-table-column>
      <el-table-column sortable prop="description" label="摘要" width="300">
      </el-table-column>
      <el-table-column sortable prop="created" label="创建时间" width="300">
        <template slot-scope="scope">
          <div>{{scope.row.editTime|timestampToTime}}</div>
        </template>
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
    <el-dialog :title="title" :visible.sync="editFormVisible" width="60%" @click="closeDialog">
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
        <el-button @click="resetForm('editForm')">重置</el-button>
        <el-button size="small" @click="closeDialog">取消</el-button>
        <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import Pagination from '../../components/Pagination'
export default {
  data() {
    return {
      nshow: true, //switch开启
      fshow: false, //switch关闭
      loading: false, //是显示加载
      editFormVisible: false, //控制编辑页面显示与隐藏
      title: '添加',
      editForm: {
        title: '',
        description: '',
        content: '',
        token: localStorage.getItem('login-token')
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
  /**
   * 数据发生改变
   */

  /**
   * 创建完毕
   */
  created() {
    this.getBlogs(this.formInline)
  },

  /**
   * 里面的方法只有被调用才会执行
   */
  methods: {

    //重置编辑
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //获取博客列表
    getBlogs(parameter) {
      this.loading = true
      /***
       * 调用接口，注释上面模拟数据 取消下面注释
       */
      this.$http.get("/api/article",parameter)
          .then(res => {
            this.blogs=[]
            for (let i in res.data.data.content){
              this.blogs.push(res.data.data.content[i])
            }
            // 分页赋值
            //this.pageparm.currentPage = this.formInline.page
            //this.pageparm.pageSize = this.formInline.limit
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
      this.getBlogs(this.formInline)
    },
    //显示编辑界面
    handleEdit: function(index, row) {
      this.editFormVisible = true
      if (row !== undefined && row !== 'undefined') {
        this.title = '修改'
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
    // 编辑、增加页面保存方法
    submitForm(editData) {
      this.$refs[editData].validate(valid => {
        if (valid) {
          deptSave(this.editForm)
              .then(res => {
                this.editFormVisible = false
                this.loading = false
                if (res.success) {
                  this.getdata(this.formInline)
                  this.$message({
                    type: 'success',
                    message: '公司保存成功！'
                  })
                } else {
                  this.$message({
                    type: 'info',
                    message: res.msg
                  })
                }
              })
              .catch(err => {
                this.editFormVisible = false
                this.loading = false
                this.$message.error('公司保存失败，请稍后再试！')
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
      })
          .then(() => {
            deptDelete(row.deptId)
                .then(res => {
                  if (res.success) {
                    this.$message({
                      type: 'success',
                      message: '公司已删除!'
                    })
                    this.getdata(this.formInline)
                  } else {
                    this.$message({
                      type: 'info',
                      message: res.msg
                    })
                  }
                })
                .catch(err => {
                  this.loading = false
                  this.$message.error('公司删除失败，请稍后再试！')
                })
          })
          .catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            })
          })
    },
    // 关闭编辑、增加弹出框
    closeDialog() {
      this.editFormVisible = false
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


