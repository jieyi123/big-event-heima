//导入request.js请求工具
import request from '@/utils/request.js'

//提供调用注册接口的函数
export const userRegisterService =(registerData)=>{
    //借助URLSearchParams完成参数传递
    const parms=new URLSearchParams()
    
    for(let key in registerData){
        parms.append(key,registerData[key]);
    }
    return request.post('/user/register',parms);
}

//注册函数
export const userLoginService =(registerData)=>{
    const parms=new URLSearchParams()
    for(let key in registerData){
        parms.append(key,registerData[key]);
    }
    return request.post('/user/login',parms);
}