package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'MinecraftForge_MinecraftForge__BuildSecondaryBranches'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("MinecraftForge_MinecraftForge__BuildSecondaryBranches")) {
    params {
        add {
            param("git_branch_spec", """
                +:refs/heads/(*)
                -:refs/heads/noci*
            """.trimIndent())
        }
    }

    vcs {

        check(branchFilter == """
            +:*             
            -:refs/heads/(develop|release|staging|main|master)
            -:<default>
            -:refs/heads/%git_main_branch%
            -:refs/heads/main*
            -:refs/heads/master*
            -:refs/heads/1.*
            -:(develop|release|staging|main|master)
            -:%git_main_branch%
            -:main*
            -:master*
            -:1.*            
        """.trimIndent()) {
            "Unexpected option value: branchFilter = $branchFilter"
        }
        branchFilter = """
            +:*
            -:1.*
            -:<default>
        """.trimIndent()
    }
}
