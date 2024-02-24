function buildMenu(divid,menulist1)
{
    //alert("hai")
	var source = builddata(menulist1);
	var ul = $("<ul class='nav' id='side-menu'></ul>");
	ul.appendTo("#"+divid);
	buildUL(ul, source);
}
function builddata(menulist1) {
    var source = [];
    var items = [];
    // build hierarchical source.
    for (i = 0; i < menulist1.length; i++) {
        var item = menulist1[i];
        var label = item["name"];
        var parentid = item["pid"];
        var id = item["id"];
        var target =item["path"];
        var menuposition=item["position"];
        var orderid=item["sid"];
if(menuposition=='SHOW')
        if (items[parentid]) {
            var item = { parentid: parentid, label: label, item: item ,target:target,orderid:orderid};
            if (!items[parentid].items) {
                items[parentid].items = [];
            }
            items[parentid].items[items[parentid].items.length] = item;
            items[id] = item;
        }
        else {
            items[id] = { parentid: parentid, label: label, item: item, target:target, orderid:orderid };
            source[id] = items[id];
        }
        
    }
    return source;
}

function buildUL(parent, items) {
    
    
    /*
	items = items.sort(function(a,b) {
  if (a.orderid < b.orderid)
     return -1;
  if (a.orderid > b.orderid)
    return 1;
  return 0;
});*/
    $.each(items, function () {
        if (this.label) {
            // create LI element and append it to the parent element.
            var li = $("<li><a href='"+this.target+"'>" + this.label + "</a></li>");
            li.appendTo(parent);
            // if there are sub items, call the buildUL function.
            if (this.items && this.items.length > 0) {
                var ul = $("<ul></ul>");
                ul.appendTo(li);
                buildUL(ul, this.items);
            }
        }
    });
}