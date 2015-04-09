function fnGenerateTags(tagsIn,renderEleId){
    var tag = tagsIn;
    var subTags = tag.substr(1,tag.length-2);
    var tagArr = subTags.split(",");
    //console.log(subTags.split(","));
    $('#'+renderEleId).val(tagArr);

    $('#'+renderEleId).tagsInput({
        width: 'auto',
        autocomplete_url:'resources/sample.txt'
    });
}