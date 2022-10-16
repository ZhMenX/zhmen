<template>
  <div class="bg" :height="fullHeight" :width="fullWidth">
    <div class="img_box">
      <!-- 背景图片：动态绑定宽高 -->
      <!-- <img src="../../assets/img/bg01.png" :width="fullWidth" /> -->
      <img src="../assets/image/background.jpg" :width="fullWidth" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 获取设备宽度、高度
      fullWidth: document.documentElement.clientWidth,
      fullHeight: document.documentElement.clientHeight,
      // 以下两个暂时没有用到
      curWidth: "",
      curHeight: "",
    };
  },
  created() {
    // 添加监听，监听设备宽高
    window.addEventListener("resize", this.handleResize);
  },
  beforeDestroy: function () {
    // 销毁监听
    window.removeEventListener("resize", this.handleResize);
  },
  computed: {
    // 处理设备宽高
  },
  methods: {
    // 处理设备宽高
    handleResize() {
      this.fullWidth = document.documentElement.clientWidth - 16;
      this.fullHeight = document.documentElement.clientHeight - 16;
      this.curWidth = this.fullWidth + "px";
      this.curHeight = this.fullHeight + "px";
      console.log("curWidth=" + this.curWidth + ",curHeight=" + this.curHeight);
    },
  },
};
</script>

<style scoped>
.bg {
  padding: 0;
  margin: 0;
}
.bg .img_box {
  width: 100%;
  height: 100%;
}
.bg .img_box img {
  position: fixed; /* 固定图片位置 */
}
</style>
