/**
* 头部菜单
*/
<template>
  <el-menu class="el-menu-demo" mode="horizontal" background-color="#334157" text-color="#fff" active-text-color="#fff">
    <el-button class="buttoning" >
      <img class="showing" :src="collapsed?imgsq:imgshow" @click="toggle(collapsed)" alt="">
    </el-button>
    <el-submenu index="2" class="submenu">
      <!-- <template slot="title">{{user.userRealName}}</template> -->
      <template slot="title">超级管理员</template>
      <el-menu-item index="2-1">设置</el-menu-item>
      <el-menu-item @click="exit()" index="2-2">返回前台</el-menu-item>
    </el-submenu>
  </el-menu>
</template>
<script>
export default {
  name: 'navcon',
  data() {
    return {
      collapsed: true,
      imgshow: require('../assets/img/show.png'),
      imgsq: require('../assets/img/sq.png'),
      user: {}
    }
  },
  // 创建完毕状态(里面是操作)
  created() {
    this.user = JSON.parse(localStorage.getItem('userdata'))
  },
  methods: {
    // 退出登录
    exit() {
      this.$confirm('返回前台需要退出登录, 是否继续?', '提示', {
        confirmButtonText: '退出',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
          this.$http.get("/user/logout")
            .then(res => {
              if (res.data.code === 200) {
                //如果请求成功就让他2秒跳转路由
                setTimeout(() => {
                  this.$store.commit('logout', 'false')
                  this.$router.push({ path: '/' })
                  this.$message({
                    type: 'success',
                    message: '已退出登录!'
                  })
                }, 1000)
                window.location.href = "http://localhost:8080/#/"  // 这个地址是你要跳转的项目url。
              } else {
                this.$message.error(res.data.msg)
                this.logining = false
                return false
              }
            })
            .catch(err => {
              this.logining = false
              this.$message.error('退出失败，请稍后再试！')
            })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          })
        })

    },
    // 切换显示
    toggle(showtype) {
      this.collapsed = !showtype
      this.$root.$bus.emit('toggle', this.collapsed)
    }
  }
}
</script>
<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  border: none;
}
.submenu {
  margin-left: 1100px;
}
.buttoning {
  height: 60px;
  background-color: #334157;
  position: absolute;
  border: none;
}
.buttoning:hover{
  background-color: #334157;
  border-color: #334157;
}
.showing {
  width: 24px;
  height: 26px;
  top: 17px;
  left: 17px;
}
.showing:active {
  border: none;
}
</style>
