<#macro sidebar urlLink urlGroup>
<div id="sidebar">
    <!-- Wrapper for scrolling functionality -->
    <div class="sidebar-scroll">
        <!-- Sidebar Content -->
        <div class="sidebar-content">
            <!-- Brand -->
            <a href="/" class="sidebar-brand">
                <#--<img src="/img/WorkBenchIcon2.png" alt="avatar"  style="height:15px;width:15px;padding: 0px;margin: 0px;margin-top: -8px; margin-left: -2px;">-->
                Bif Fat Populator
            </a>
            <!-- END brand -->

            <!-- User Info -->
            <div class="sidebar-section">
                <div class="sidebar-user-name">DEV</div>

            </div>
            <!-- END User Info -->
            <!-- Sidebar Navigation -->
            <ul class="sidebar-nav">
                <li>
                    <a href="/" class="<#if urlLink == 'report'>active</#if>"><i class="fa fa-terminal sidebar-nav-icon"></i>Report</a>
                </li>
                <li>
                    <a href="/flowErrors" class="<#if urlLink == 'flowErrors'>active</#if>"><i class="fa fa-warning sidebar-nav-icon"></i>Error Log</a>
                </li>
                <li>
                    <a href="/mprn" class="<#if urlLink == 'mprnGen'>active</#if>"><i class="fa fa-code sidebar-nav-icon"></i>MPRN Generation</a>
                </li>
                <li>
                    <a href="/flowTemplate" class="<#if urlLink == 'flowTemplate'>active</#if>"><i class="fa fa-rebel sidebar-nav-icon"></i>Templates</a>
                </li>
                <li>
                    <a href="#" class="sidebar-nav-menu <#if urlGroup == 'admin'>open</#if>">
                        <i class="fa fa-angle-left sidebar-nav-indicator"></i>
                        <i class="fa fa-cogs sidebar-nav-icon"></i>
                        Admin
                    </a>
                    <ul <#if urlGroup == 'admin' >style="display: block"</#if>>
                        <li>
                            <a href="/scenario" class="<#if urlLink == 'scenario'>active</#if>"><i class="fa fa-cogs sidebar-nav-icon"></i>Scenario</a>
                        </li>
                        <li>
                            <a href="/settings" class="<#if urlLink == 'systemParameters'>active</#if>"><i class="fa fa-cogs sidebar-nav-icon"></i>System Parameters</a>
                        </li>
                    </ul>
                </li>


            </ul>
            </div>
        </div>
    </div>
</#macro>