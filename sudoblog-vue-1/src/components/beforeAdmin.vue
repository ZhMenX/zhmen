<template>
  <el-button type="info" round @click="linkRouter('About')"
  >关于我们</el-button
  >
</template>

<script>
export default {
  name: "beforeAdmin",
  methods: {
    linkRouter: function (viewName) {
      this.$router.push({ name: viewName });
    },
  }
};
</script>

<style scoped>

</style>