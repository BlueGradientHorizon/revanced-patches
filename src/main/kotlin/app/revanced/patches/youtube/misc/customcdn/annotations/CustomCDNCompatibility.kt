package app.revanced.patches.youtube.misc.customcdn.annotations

import app.revanced.patcher.annotation.Compatibility
import app.revanced.patcher.annotation.Package

@Compatibility([Package("com.google.android.youtube")])
@Target(AnnotationTarget.CLASS)
annotation class CustomCDNCompatibility()
