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

//登录
export const userLoginService =(registerData)=>{
    const parms=new URLSearchParams()
    for(let key in registerData){
        parms.append(key,registerData[key]);
    }
    return request.post('/user/login',parms);
}

//获取用户个人信息
export const userInfoGetService=()=>{
    return request.get('/user/userInfo');
}

//更新用户信息
export const updateUserInfo=(userInfo)=>{
    return request.put('/user/update',userInfo)
}

//修改用户头像
export const updateUserAvatarServie=(avatarUrl)=>{
    let params=new URLSearchParams();
    params.append('avatarUrl',avatarUrl)
    return request.patch('/user/updateAvatar',params)
}