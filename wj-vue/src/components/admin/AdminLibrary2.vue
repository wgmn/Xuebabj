<template>
  <el-container>
    <div>
      <el-row style="z-index: 1;">
        <a href="/index">
          <img src="../../assets/img/icon/icon2.png" alt="" width="80px" style="float: left;margin-top: -5px;">
        </a>
        <span style="font-size: 32px;font-weight: bold;position:absolute;left: 100px">学霸笔记</span>
        <i class="el-icon-s-unfold" style="font-size: 20px;float: right"></i>
      </el-row>
      <el-row style="z-index: 0;">
        <el-col style="width: 250px" >
          <admin-menu></admin-menu>
        </el-col>
      </el-row>
    </div>
    <el-table
      fixed="right"
      :data="books"
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
        prop="title"
        label="书名"
        width="350">
      </el-table-column>
      <el-table-column
        prop="abs"
        label="简介"
        width="350">
      </el-table-column>
      <el-table-column
        prop="author"
        label="作者"
        width="350">
      </el-table-column>
      <el-table-column
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="deletebook(scope.row.id)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <edit-users ref="edit"></edit-users>
  </el-container>
</template>

<script>
    import AdminMenu from './AdminMenu'
    import Header from './Header'
    export default {
        name: 'AdminLibrary2',
        components: {AdminMenu, Header},
      mounted: function () {
        this.loadArticles()
      },
        data () {
            return {
               books: []
            }
        },
      methods: {
          loadArticles () {
            var _this = this
            this.$axios.get('/books/admin2').then(resp => {
              if (resp && resp.status === 200) {
                _this.books = resp.data
          }
      })
          },
          deletebook (id) {
            this.$confirm('此操作将永久删除该书籍, 是否继续?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
                this.$axios
                  .post('/books/delete1', {id: id}).then(resp => {
                  if (resp && resp.status === 200) {
                    this.loadArticles()
                  }
                })
              }
            ).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消删除'
              })
            })
          }
    }
    }
</script>
