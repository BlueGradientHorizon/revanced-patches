package app.revanced.patches.youtube.misc.customcdn.fingerprints
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object CustomCDNFingerprint : MethodFingerprint(
    strings = listOf(
        "yt3.ggpht.com"
    )
)