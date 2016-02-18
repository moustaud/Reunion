<div class="col-md-5">
        <div class="panel panel-green">
            <div class="panel-heading">All users</div>
            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Select</th>
                        <th>Picture</th>
                        <th>Username</th>
                        
                    </tr>
                    </thead>
                    <tbody id="listOfUsers">

                        <g:each in="${meeting.participants}" var="user">
                            <tr id="${user.id}">
                                <td><input type="checkbox" name="users" value="${user.id}"></td>
                                <td><img src="${assetPath(src: user.picture)}"
                                    class="picture-30"></td>
                                <td>${user.login}</td>
                                
                            </tr>
                        </g:each>
                    
                    </tbody>
                </table>
            </div>
        </div>
</div>