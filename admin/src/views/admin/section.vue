<template>
    <div>
        <p>
            <button v-on:click="add()" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-edit"></i>
                New
            </button>
            &nbsp;
            <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-refresh"></i>
                Refresh
            </button>
        </p>

        <pagination ref="pagination" v-bind:list="list"></pagination>

        <table id="simple-table" class="table  table-bordered table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>标题</th>
                <th>课程</th>
                <th>大章</th>
                <th>视频</th>
                <th>时长</th>
                <th>收费</th>
                <th>顺序</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>vod</th>
                <th>Operations</th>
            </tr>
            </thead>

            <tbody>
                <tr v-for="section in sections">
                        <td>{{ section.id }}</td>
                        <td>{{ section.title }}</td>
                        <td>{{ section.courseId }}</td>
                        <td>{{ section.chapterId }}</td>
                        <td>{{ section.video }}</td>
                        <td>{{ section.time }}</td>
                        <td>{{ section.charge }}</td>
                        <td>{{ section.sort }}</td>
                        <td>{{ section.createdAt }}</td>
                        <td>{{ section.updatedAt }}</td>
                        <td>{{ section.vod }}</td>
                    <td>
                        <div class="hidden-sm hidden-xs btn-group">
                            <button v-on:click="edit(section)" class="btn btn-xs btn-info">
                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                            </button>
                            <button v-on:click="del(section.id)" class="btn btn-xs btn-danger">
                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                            </button>
                        </div>

                        <div class="hidden-md hidden-lg">
                            <div class="inline pos-rel">
                                <button class="btn btn-minier btn-primary dropdown-toggle"
                                        data-toggle="dropdown" data-position="auto">
                                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                </button>

                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li>
                                        <a href="#" class="tooltip-info" data-rel="tooltip"
                                           title="View">
                                            <span class="blue">
                                                <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                            </span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-success" data-rel="tooltip"
                                           title="Edit">
                                            <span class="green">
                                                <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                            </span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-error" data-rel="tooltip"
                                           title="Delete">
                                            <span class="red">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>

        <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">New Section</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">id</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.id" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">标题</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.title" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">课程</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.courseId" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">大章</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.chapterId" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">视频</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.video" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">时长</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.time" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">收费</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.charge" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">顺序</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.sort" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">创建时间</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.createdAt" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">修改时间</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.updatedAt" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">vod</label>
                                    <div class="col-sm-10">
                                        <input v-model="section.vod" type="text" class="form-control">
                                    </div>
                                </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <button v-on:click="save" type="button" class="btn btn-primary">Save</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</template>

<script>
    import Pagination from "../../components/pagination";
    export default {
        name: 'welcome',
        components: {Pagination},
        data: function() {
          return {
              section: {},
              sections: []
          }
        },
        mounted: function () {
            // sidebar激活样式方法一
            // this.$parent.activeSidebar("business-section-sidebar"
            let _this = this;
            _this.$refs.pagination.size = 5;
            _this.list(1);
        },
        methods: {
            /**
             * 点击【新增】
             */
            add() {
                let _this = this;
                _this.section = {};
                $("#form-modal").modal("show");
                // $("#form-modal").modal("hide");
            },

            /**
             * 点击【编辑】
             */
            edit(section) {
                let _this = this;
                _this.section = $.extend({}, section);
                $("#form-modal").modal("show");
                // $("#form-modal").modal("hide");
            },

            /**
             * 列表查询
             */
            list(page) {
                let _this = this;
                Loading.show();
                _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/section/list', {
                    page: page,
                    size: _this.$refs.pagination.size,
                }).then((response) => {
                    Loading.hide();
                    console.log("Result from querying section table: ", response);
                    let resp = response.data;
                    _this.sections = resp.content.list;
                    _this.$refs.pagination.render(page, resp.content.total)
                })
            },

            /**
             * 点击【保存】
             */
            save(page) {
                let _this = this;

                // 保存校验


                Loading.show();
                _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/section/save', _this.section).then((response) => {
                    Loading.hide();
                    console.log("Save a new section: ", response);
                    let resp = response.data;
                    if (resp.success) {
                        $("#form-modal").modal("hide");
                        _this.list(1);
                        Toast.success("Saved successfully!");
                    } else {
                        Toast.warning(resp.message);
                    }
                })
            },

            /**
             * 点击【删除】
             */
            del(id) {
                let _this = this;
                Confirm.show("You won't be able to revert this!", function () {
                    Loading.show();
                    _this.$ajax.delete(process.env.VUE_APP_SERVER + '/business/admin/section/delete/' + id).then((response) => {
                        Loading.hide();
                        console.log("Delete a section: ", response);
                        let resp = response.data;
                        if (resp.success) {
                            _this.list(1);
                            Toast.success("Deleted!");
                        }
                    })
                })
            }
        }
    }
</script>