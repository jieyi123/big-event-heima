import request from '@/utils/request.js'
import { useTokenStore } from '@/stores/token'

//文章分类列表查询
export const articleCategoryListService=()=>{
    const tokenStore=useTokenStore();
    //pinia绑定的响应式对象都不需要通过.value来获取值
    //return request.get('/category',{headers:{'Authorization':tokenStore.token}})
    return request.get('/category')
}
//文章分类添加
export const articleCategoryAddService=(categoryData)=>{
    return request.post('/category',categoryData)
}

//修改文章分类
export const articleCategoryUpdateService=(categoryData)=>{
    return request.put('/category',categoryData)
}

//删除分类
export const articleCategoryDeleteService = (id) => {
    return request.delete('/category?id='+id)
}