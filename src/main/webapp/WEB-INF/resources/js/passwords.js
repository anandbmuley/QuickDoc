$(document).ready(function(){
            $('#searchBox').autocomplete({
                source: "./search?searchBy=2",
                minLength: 2,
                select: function( event, ui ) {
                    $('#searchTitleBox').val(ui.item.value);
                    $('#searchFrm').attr('action','searchpassword');
                    $('#searchFrm').submit();
                }
            });

            $('#searchTitleBox').autocomplete({
                source: "./search?searchBy=1",
                minLength: 2,
                select: function( event, ui ) {
                    $('#searchTitleBox').val(ui.item.value);
                    $('#searchFrm').attr('action','searchpassword');
                    $('#searchFrm').submit();
                }
            });

            $('#addTag').tagsInput({
                width: 'auto',
                autocomplete_url:'resources/sample.txt'
            });

             $('.allowCopy').click(function() {
                 var $temp = $("<input>");
                 $("body").append($temp);
                 $temp.val($(this).attr('value')).select();
                 document.execCommand("copy");
                 $temp.remove();
                 $('#copyToClipboardMessage').show();
                  $('#copyToClipboardMessage').fadeOut(1500);
             });

});