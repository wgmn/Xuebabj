<template>
  <el-container>
  <div>
    <el-row style="z-index: 1;">
      <Header style="position: absolute;width: 100%;"></Header>
    </el-row>
    <el-row style="z-index: 0;">
      <el-col style="width: 250px" >
        <admin-menu></admin-menu>
      </el-col>
    </el-row>
  </div>
  <el-table
    fixed="right"
    :data="users"
    border
    style
  >
    <el-table-column
      fixed
      prop="id"
      label="ID"
      width="300"
    ></el-table-column>
    <el-table-column
      prop="username"
      label="username"
      width="350">
    </el-table-column>
    <el-table-column
      prop="data"
      label="姓名"
      width="350">
    </el-table-column>
    <el-table-column
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
  </el-container>
</template>

<script>
  import AdminMenu from './AdminMenu'
  import Header from './Header'

  export default {
    name: 'AdminIndex',
    components: {AdminMenu, Header},

    mounted: function () {
      this.loadUsers()
    },

    data () {
      return {
        users: []
      }
    },

    methods: {
      loadUsers () {
        var _this = this
        this.$axios.get('/users').then(resp => {
          if (resp && resp.status === 200) {
            _this.users = resp.data
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
