import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

Vue.component('TopMenu', () => import('../components/top-menu/index.vue'));

const routes = [{
    path: '/',
    name: 'Index',
    component: () => import('../views/index/index.vue')
}, {
    path: '/Login',
    name: 'Login',
    component: () => import('../views/login/index.vue')
}, {
    path: '/Menu',
    name: 'Menu',
    component: () => import('../views/menu/index.vue')
}, {
    path: '/OperationUser',
    name: 'OperationUser',
    component: () => import('../views/operation-user/index.vue')
}]

const router = new VueRouter({
    base: process.env.BASE_URL,
    routes
})

export default router