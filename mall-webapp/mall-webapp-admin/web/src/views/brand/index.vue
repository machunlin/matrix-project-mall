<template>
    <div>
        <top-menu></top-menu>
        <el-container>
            <el-main>
                <el-tabs type="card" v-model="activeName">
                    <el-tab-pane label="列表" name="list">
                        <el-row>
                            <el-col :span="24">
                                <el-form :inline="true" label-position='center' label-width="80px">
                                    <el-form-item label="品牌名">
                                        <el-input clearable size="small" v-model="queryForm.brandName"></el-input>
                                    </el-form-item>
                                </el-form>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="24">
                                <el-button @click="loadTable" size="small" type="primary">刷新</el-button>
                                <el-button @click="append" size="small" type="primary">新增</el-button>
                                <el-button :disabled="selection.length !== 1" @click="detail(selection[0])" size="small"
                                           type="primary">
                                    编辑
                                </el-button>
                                <el-button :disabled="selection.length !== 1" @click="remove" size="small"
                                           type="danger">删除
                                </el-button>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="24">
                                <el-table :data="brandList" @row-dblclick="detail"
                                          @selection-change="handleSelectionChange"
                                          border
                                          style="width: 100%;margin-top: 5px;">
                                    <el-table-column type="selection" width="55"></el-table-column>
                                    <el-table-column label="品牌ID" prop="brandId" width="250"></el-table-column>
                                    <el-table-column label="品牌名" prop="brandName" width="180"></el-table-column>
                                    <el-table-column label="品牌Logo" width="180">
                                        <template slot-scope="scope">
                                            <img :src="scope.row.brandLogo"
                                                 height="100"
                                                 v-if="scope.row.brandLogo != null && scope.row.brandLogo.length > 0"
                                                 width="100"/>
                                        </template>
                                    </el-table-column>
                                    <el-table-column label="品牌链接" width="180">
                                        <template slot-scope="scope">
                                            <a :href="scope.row.brandUrl" target="_blank"
                                               v-if="scope.row.brandUrl != null && scope.row.brandUrl.length > 0">{{scope.row.brandUrl}}</a>
                                        </template>
                                    </el-table-column>
                                    <el-table-column label="创建时间" prop="createTime"></el-table-column>
                                    <el-table-column label="更新时间" prop="updateTime"></el-table-column>
                                </el-table>
                                <el-pagination :page-count="queryForm.pageSize"
                                               :page-sizes="[20, 50, 100]" :total="brandCount"
                                               @current-change="handleCurrentChange"
                                               @size-change="handleSizeChange" background
                                               layout="total, prev, pager, next, sizes"
                                               style="text-align: right;margin-top: 20px;"></el-pagination>
                            </el-col>
                        </el-row>
                    </el-tab-pane>
                    <el-tab-pane label="详情" name="detail" v-if="showDetail">
                        <el-row>
                            <el-col :span="24">
                                <el-form :model="ruleForm" :rules="rules" label-width="100px" ref="ruleForm">
                                    <el-form-item label="品牌名称" prop="brandName">
                                        <el-input size="small" style="width: 200px"
                                                  v-model="ruleForm.brandName"></el-input>
                                    </el-form-item>
                                    <el-form-item label="品牌Url" prop="brandUrl">
                                        <el-input size="small" style="width: 200px"
                                                  v-model="ruleForm.brandUrl"></el-input>
                                    </el-form-item>
                                    <el-form-item label="品牌Logo" prop="brandLogo">
                                        <file-upload :change="uploadImagesChange" :fileList="upload.images" :limit="1"
                                                     :tip="upload.tip"
                                                     list-type="picture"
                                                     style="width: 350px;" type="Image"></file-upload>
                                    </el-form-item>
                                    <el-form-item>
                                        <el-button @click="save" size="small" type="primary">保存</el-button>
                                    </el-form-item>
                                </el-form>
                            </el-col>
                        </el-row>
                    </el-tab-pane>
                </el-tabs>
            </el-main>
        </el-container>
    </div>
</template>
<script type="text/javascript">
    import {data} from './index.js';

    export default data;
</script>
<style scoped type="text/css">
    .el-main {
        padding-left: 2px;
        padding-right: 2px;
    }
</style>