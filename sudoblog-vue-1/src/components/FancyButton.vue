<template>
  <button class="fancy-btn">
    <slot />
  </button>
</template>

<script>
export default {
  name: "FancyButton",
};
</script>

<style scoped>
.fancy-btn {
  color: #fff;
  background: linear-gradient(315deg, #42d392 25%, #647eff);
  border: none;
  padding: 5px 10px;
  margin: 5px;
  border-radius: 8px;
  cursor: pointer;
}
</style>
