import axios from 'axios'
import { useUserStore } from '../store/user'

const instance = axios.create({
  baseURL: '/api',  // 代理到后端
  timeout: 5000
})

// 请求拦截器
instance.interceptors.request.use(config => {
  const store = useUserStore()
  if (store.token) {
    config.headers.Authorization = store.token
  }
  return config
})

// 响应拦截器
instance.interceptors.response.use(
  res => res.data,
  err => {
    console.error('请求错误:', err)
    return Promise.reject(err)
  }
)

export default instance
