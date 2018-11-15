<script type="application/javascript">

    $(document).ready(function(){
        $('#searchBox').autocomplete({
            source: "./search?searchBy=2",
            minLength: 2,
            select: function( event, ui ) {
                $('#searchTitleBox').val(ui.item.value);
                $('#searchFrm').submit();
            }
        });

        $('#searchTitleBox').autocomplete({
            source: "./search?searchBy=1",
            minLength: 2,
            select: function( event, ui ) {
                $('#searchTitleBox').val(ui.item.value);
                $('#searchFrm').submit();
            }
        });

    });

</script>

<nav role="navigation" class="navbar">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button data-target="#bs-example-navbar-collapse-9" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="${pageContext.request.contextPath}/notes/index" class="navbar-brand">QuickDoc</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div id="bs-example-navbar-collapse-9" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/notes/add">Create</a></li>
            <li><a href="${pageContext.request.contextPath}/passwords/home">Passwords</a></li>
          </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" style="color: #ffffff;">Developer - Anand Muley</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    <div class="ui-widget">
        <form id="searchFrm" method="post" action="searchnote" role="form">
           <div class="table">
               <div class="table-row">
                   <div class="table-cell">
                       <input id="searchBox" name="tag" type="text" class="form-control input" placeholder="Search by tags">
                   </div>

                   <div class="table-cell">
                       <input id="searchTitleBox" name="title" type="text" class="form-control input" placeholder="Search by title">
                   </div>
               </div>
           </div>
        </form>
    </div>
