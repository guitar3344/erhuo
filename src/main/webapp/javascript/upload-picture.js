/**
 * Created by guitar on 15/2/2.
 */
var uploadPicture = function(){
    // 初始化Web Uploader
    var uploader = WebUploader.create({

        // 选完文件后，是否自动上传。
        auto: true,

        // swf文件路径
        swf: '/plugin/webuploader/Uploader.swf',

        // 文件接收服务端。
        server: '/picture/goods',

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker',

        // 只允许选择图片文件。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });

    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {
        var $li = $(
                    '<div id="' + file.id + '" class="eh_pic_item thumbnail">' +
                    '<img>' +
                    '</div>'
            ),
            $img = $li.find('img');


        // $list为容器jQuery实例
        $("#picList").append( $li );

        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        var thumbnailWidth = 120;
        var thumbnailHeight = 120;
        uploader.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, thumbnailWidth, thumbnailHeight );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<div class="progress active">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                '</div>' +
                '</div>').appendTo( $li ).find('.progress-bar');
        }

        $li.find('p.state').text('上传中');

        $percent.css( 'width', percentage * 100 + '%' );
    });

    uploader.on( 'uploadSuccess', function( file,response ) {
        $( '#'+file.id ).find('p.state').text('已上传');
        var goods_pic = $("#goods_pic").val();
        if(goods_pic && goods_pic.length>0){
            $("#goods_pic").val(goods_pic+","+response.value);
        }else{
            $("#goods_pic").val(response.value);
        }

    });
}
