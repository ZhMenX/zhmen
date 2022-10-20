<template>

  <el-container class="index-con">
    <el-aside :class="showclass" style="background-color: #334157">
      <leftnav></leftnav>
    </el-aside>
    <el-container class="main-con">
      <el-header class="index-header">
        <navcon></navcon>
      </el-header>
      <el-main clss="index-main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import navcon from '../components/navcon.vue'
import leftnav from '../components/leftnav.vue'
export default {
  name: "Index",
  data(){
    return {
      showclass: 'sideshow',
      showtype: false
    }
  },
  // 注册组件
  components: {
    navcon,
    leftnav
  },
  created() {
    // 监听
    this.$root.$bus.on('toggle', value => {
      if (value) {
        this.showclass = 'asideshow'
      } else {
        setTimeout(() => {
          this.showclass = 'aside'
        }, 0)
      }
    })
  },
  beforeUpdate() {},
  // 挂载前状态(里面是操作)
  beforeMount() {
    // 弹出登录成功
    this.$message({
      message: '登录成功',
      type: 'success'
    })
  }
}
</script>

<style scoped>
.index-con {
  height: 100%;
  width: 100%;
  box-sizing: border-box;
}

.aside {
  width: 64px !important;
  height: 100%;
  background-color: #334157;
  margin: 0px;
}
.asideshow {
  width: 240px !important;
  height: 100%;
  background-color: #334157;
  margin: 0;
}
.index-header,
.index-main {
  padding: 0;
  border-left: 2px solid #333;
}
</style>
