import './assets/main.scss'

import { createApp } from 'vue'
import App from './App.vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import locale from 'element-plus/dist/locale/zh-cn.js'

import router from '@/router/index.js'

//导入pinia的持久化对象 pinia默认在刷新的时候数据就没了
//定义状态Store时指定持久化配置参数
import {createPersistedState} from 'pinia-persistedstate-plugin'

import {createPinia} from 'pinia'
const app=createApp(App)
const pinia=createPinia();
const persist=createPersistedState();
pinia.use(persist)
app.use(pinia)
app.use(router)
app.use(ElementPlus,{locale})
app.mount('#app')
