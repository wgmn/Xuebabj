import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '../components/home/AppIndex'
import Editor from '../components/jotter/Editor'
import LibraryIndex from '../components/library/LibraryIndex'
import Login from '../components/Login'
import Home from '../components/Home'
import Register from '../components/Register'
import AdminIndex from '../components/admin/AdminIndex'
import AdminUsers from '../components/admin/AdminUsers'
import AdminLibrary from '../components/admin/AdminLibrary'
import EditUsers from '../components/admin/EditUsers'
import AdminLibrary2 from '../components/admin/AdminLibrary2'
import LibraryIndex1 from '../components/new_joker/LibraryIndex1'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'index',
      redirect: '/index',
      component: AppIndex,
      meta: {
        requireAuth: true
      }
    },
    {
      // home页面并不需要被访问，只是作为其它组件的父组件
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/new_joker',
          name: 'New_joker',
          component: LibraryIndex1,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/editor',
          name: 'Editor',
          component: Editor,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/admin/EditUsers',
          name: 'EditUsers',
          component: EditUsers,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/admin/AdminUsers',
      name: 'AdminUsers',
      component: AdminUsers,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/admin/AdminLibrary',
      name: 'AdminLibrary',
      component: AdminLibrary,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/admin/AdminLibrary2',
      name: 'AdminLibrary2',
      component: AdminLibrary2,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/admin',
      name: 'Admin',
      component: AdminIndex,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/admin/EditUsers',
      name: 'EditUsers',
      component: EditUsers
    }
  ]
})
