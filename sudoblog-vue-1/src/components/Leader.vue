<template>
  <el-col>
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
    >
      <el-menu-item index="1">
        <router-link to="/">首页</router-link>
      </el-menu-item>
      <el-menu-item index="2">
        <router-link to="/learn">学习</router-link>
      </el-menu-item>
      <el-menu-item index="3">
        <router-link to="/discuss">技术探讨</router-link>
      </el-menu-item>
      <el-menu-item index="4">
        <router-link to="/article">博客文章</router-link>
      </el-menu-item>
    </el-menu>
  </el-col>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Header",
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    linkRouter: function (viewName) {
      this.$router.push({ name: viewName });
    },
  },
};
</script>

<style scoped></style>
