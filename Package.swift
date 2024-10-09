// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorBiofaceAuth",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorBiofaceAuth",
            targets: ["BiofaceAuthPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "BiofaceAuthPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/BiofaceAuthPlugin"),
        .testTarget(
            name: "BiofaceAuthPluginTests",
            dependencies: ["BiofaceAuthPlugin"],
            path: "ios/Tests/BiofaceAuthPluginTests")
    ]
)