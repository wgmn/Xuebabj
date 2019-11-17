<template>
  <div>
    <el-menu
      :default-active="'/admin/users'"
      class="el-menu-admin"
      router
      mode="vertical"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <div style="height: 80px;"></div>
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name" style="font-size: 18px">
        <i :class="item.icon"></i>
        {{ item.navItem }}
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
    export default {
      name: 'AdminMenu',
      data () {
        return {
          navList: [
            {name: '/admin/AdminUsers', navItem: '用户管理', icon: 'el-icon-user'},
            {name: '/admin/AdminLibrary', navItem: '上传管理', icon: 'el-icon-tickets'},
            {name: '/admin/AdminLibrary2', navItem: '笔记管理', icon: 'el-icon-tickets'}
          ],
          keywords: ''
        }
      }
    }
</script>

<style scoped>
  .el-menu-admin {
    height: 1200px;
    font-size: 30px;
    border-radius: 5px;
  }
</style>
