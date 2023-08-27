package app.revanced.patches.youtube.misc.customcdn.patch

import app.revanced.extensions.toErrorResult
import app.revanced.patcher.patch.BytecodePatch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.data.toMethodWalker
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patcher.util.proxy.mutableTypes.MutableMethod
import app.revanced.patches.youtube.misc.customcdn.annotations.CustomCDNCompatibility
import app.revanced.patches.youtube.misc.customcdn.fingerprints.CustomCDNFingerprint
import app.revanced.patches.youtube.misc.fix.playback.fingerprints.ProtobufParameterBuilderFingerprint
import app.revanced.patches.youtube.misc.fix.playback.patch.SpoofSignatureVerificationPatch

@Patch
@Name("Change default CDN")
@Description("Changes default CDN \"yt3.ggpht.com\" to \"yt4.ggpht.com\"")
//@DependsOn([SettingsPatch::class])
@CustomCDNCompatibility
class CustomCDNPatch : BytecodePatch(
    listOf(CustomCDNFingerprint)
) {
    override fun execute(context: BytecodeContext): PatchResult {
//        var result = CustomCDNFingerprint.result!!
//        var customCDNFingerprintMethod = result.mutableMethod
//
//        customCDNFingerprintMethod.replaceInstruction(
//            0,
//            ""
//        )

        CustomCDNFingerprint.result?.let {result ->
            result.scanResult.stringsScanResult!!.matches.forEach { s ->
                println("${s.index}: ${s.string}")
            }
        } ?: return CustomCDNFingerprint.toErrorResult()

        return PatchResultSuccess()
    }
}
