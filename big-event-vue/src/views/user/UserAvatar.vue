<script setup>
import { Plus, Upload } from '@element-plus/icons-vue'
import {ref} from 'vue'
import avatar from '@/assets/default.png'
const uploadRef = ref()

//用户头像地址

//从pinia中获取用户头像地址
import useUserInfoStore from '@/stores/userInfo.js'
const userInfo=useUserInfoStore()
const imgUrl= ref(userInfo.info.userPic)

//导入token
import {useTokenStore} from '@/stores/token.js'
const tokenStore=useTokenStore()
const uploadSuccess=(result)=>{
    //回显图片
    imgUrl.value=result.data
}
//修改头像 
import {updateUserAvatarServie} from '@/api/user.js'
import { ElMessage } from 'element-plus';
const updataAvatar=async()=>{
    let reslut=await updateUserAvatarServie(imgUrl.value)
    ElMessage.success(reslut.message?reslut.message:'修改成功')
    //更新pinia中的数据
    userInfo.info.userPic=imgUrl.value
}

</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>更换头像</span>
            </div>
        </template>
        <el-row>
            <el-col :span="12">
                <el-upload 
                    ref="uploadRef"
                    class="avatar-uploader" 
                    :show-file-list="false"
                    action="/api/upload"
                    :auto-upload="true"
                    :headers="{'Authorization':tokenStore.token}"
                    :on-success="uploadSuccess"
                    >
                    <img v-if="imgUrl" :src="imgUrl" class="avatar" />
                    <img v-else :src="avatar" width="278" />
                </el-upload>
                <br />
                <el-button type="primary" :icon="Plus" size="large"  @click="uploadRef.$el.querySelector('input').click()">
                    选择图片
                </el-button>
                <el-button type="success" :icon="Upload" size="large" @click="updataAvatar">
                    上传头像
                </el-button>
            </el-col>
        </el-row>
    </el-card>
</template>

<style lang="scss" scoped>
.avatar-uploader {
    :deep() {
        .avatar {
            width: 278px;
            height: 278px;
            display: block;
        }

        .el-upload {
            border: 1px dashed var(--el-border-color);
            border-radius: 6px;
            cursor: pointer;
            position: relative;
            overflow: hidden;
            transition: var(--el-transition-duration-fast);
        }

        .el-upload:hover {
            border-color: var(--el-color-primary);
        }

        .el-icon.avatar-uploader-icon {
            font-size: 28px;
            color: #8c939d;
            width: 278px;
            height: 278px;
            text-align: center;
        }
    }
}
</style>