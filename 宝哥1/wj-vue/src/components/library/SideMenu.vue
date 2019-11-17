<template>
  <el-menu
    class="categories"
    default-active="0"
    @select="handleSelect"
    active-text-color="red">
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">语文</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">数学</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-menu"></i>
      <span slot="title">英语</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-menu"></i>
      <span slot="title">物理</span>
    </el-menu-item>
    <el-menu-item index="5">
      <i class="el-icon-menu"></i>
      <span slot="title">化学</span>
    </el-menu-item>
    <el-menu-item index="6">
      <i class="el-icon-menu"></i>
      <span slot="title">生物</span>
    </el-menu-item>
    <el-menu-item index="7">
      <i class="el-icon-menu"></i>
      <span slot="title">地理</span>
    </el-menu-item>
    <el-menu-item index="8">
      <i class="el-icon-menu"></i>
      <span slot="title">历史</span>
    </el-menu-item>
    <el-menu-item index="9">
      <i class="el-icon-menu"></i>
      <span slot="title">政治</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
    export default {
      name: 'SideMenu',
      data () {
        return {
          cid: ''
        }
      },
      methods: {
        // handleOpen (key, keyPath) {
        //   console.log(key, keyPath)
        // },
        handleSelect (key, keyPath) {
          this.cid = key
          this.$emit('indexSelect')
        }
      }
    }
</script>

<style scoped>
  .categories {
    position: fixed;
    margin-left: 50%;
    left: -600px;
    top: 100px;
    width: 150px;
  }
</style>
