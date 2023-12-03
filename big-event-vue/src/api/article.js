import request from '@/utils/request.js'
import { useTokenStore } from '@/stores/token'

//文章分类列表查询
export const articleCategoryListService=()=>{
    const tokenStore=useTokenStore();
    //pinia绑定的响应式对象都不需要通过.value来获取值
    //return request.get('/category',{headers:{'Authorization':tokenStore.token}})
    return request.get('/category')
}