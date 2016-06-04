<#global pageTitle = "Player" urlLink="player" urlGroup="">
<#import "/layout/layout.ftl" as layout/>
<@layout.mainLayout urlLink urlGroup>
<div class="row">
    <xmp id="messageLog" class="terminal">${player.toJSON!""}</xmp>
</div>
</@layout.mainLayout>