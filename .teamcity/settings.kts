import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2018.1"

project {
    description = "Xirgo Common Library"

    vcsRoot(XirgoCommonLib_1)

    buildType(XirgoCommonLib)
}

object XirgoCommonLib : BuildType({
    name = "XirgoCommonLib"
    description = "Xirgo Common Library"

    vcs {
        root(XirgoCommonLib_1)
    }
})

object XirgoCommonLib_1 : GitVcsRoot({
    id("XirgoCommonLib")
    name = "XirgoCommonLib"
    url = "ssh://git@bitbucket.xirgotech.com:7999/xdm/xirgocommonlib.git"
    authMethod = uploadedKey {
        uploadedKey = "id_rsa"
    }
})
