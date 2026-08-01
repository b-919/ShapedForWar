package b919.SFWar.content.units;

import b919.SFWar.content.SFWarUpgrades;
import b919.SFWar.content.bullets.SuperRaulCannonBullet;
import b919.SFWar.utils.SFWarFX;
import b919.SFWar.world.upgrade.UpgradeScalingBulletType;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.gen.MechUnit;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
public class DebugUnit {
    public static UnitType debugDagger, debugFirst, debugSecond, spriteTest;

    public static void load(){
        debugDagger = new UnitType("debug-dagger"){{
            constructor = MechUnit::create;
            speed = 0.5f;
            hitSize = 8f;
            health = 180f;
            armor = 1f;
            weapons.add(new Weapon(){{
                bullet = new UpgradeScalingBulletType(5f, 12f){{
                    damageUpgrade = SFWarUpgrades.damageUpgrade;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.hitBulletSmall;
                    despawnEffect = Fx.hitBulletSmall;
                }};
                reload = 24f;
                x = 4.25f;
                y = 1f;
            }});
        }};
        debugFirst = new UnitType("debug-first"){{
            speed = 9f;
            accel = 0.08f;
            drag = 0.04f;
            flying = true;
            health = 700*1000;
            armor = 500*1000;
            hitSize = 1;
            itemCapacity = 10;
            circleTarget = true;
            omniMovement = true;
            lowAltitude = false;
            rotateSpeed = 5f;
            wreckSoundVolume = 0.7f;

            moveSound = Sounds.loopThruster;
            moveSoundPitchMin = 0.3f;
            moveSoundPitchMax = 1.5f;
            moveSoundVolume = 0.2f;

            weapons.add(new Weapon("b919-sfwar-debug-first-pointer"){{
                y = 1f;
                x = 0f;
                minShootVelocity = 2f;
                shootCone = 10;
                reload = 800f;
                rotate = true;
                shoot.shots = 1;
                shoot.shotDelay = 3f;
                ejectEffect = Fx.casing1;
                mirror = false;
                bullet = new SuperRaulCannonBullet(){{
                    shootEffect = SFWarFX.instShootHeaven;
                    hitEffect = SFWarFX.instHitHeaven;
                    pierceEffect = Fx.railHit;
                    smokeEffect = Fx.smokeCloud;
                    pointEffect = SFWarFX.instTrailHeaven;
                    despawnEffect = SFWarFX.instBombHeaven;
                    pointEffectSpace = 30f;
                    damage = 35000;
                    splashDamageRadius = 150f;
                    splashDamage = 5000f;
                    buildingDamageMultiplier = 2f;
                    pierceDamageFactor = 1f;
                    length = 1200f;
                    hitShake = 3f;
                    ammoMultiplier = 1f;
                }};
            }});
        }};
        debugSecond = new UnitType("debug-second"){{
            health = 2500;
            speed = 6f;
            accel = 0.03f;
            drag = 0.008f;
            flying = true;
            range = 140f;
            hitSize = 36f;
            circleTarget = true;
            lowAltitude = true;
            forceMultiTarget = true;
            armor = 12f;

            engineOffset = 12f;
            engineSize = 3f;

            weapons.add(new Weapon("b919-sfwar-debug-machinegun"){{
                y = 5.75f;
                x = 2.25f;
                minShootVelocity = 2f;
                shootCone = 10f;
                reload = 2f;
                shoot.shots = 1;
                shoot.shotDelay = 2f;
                ejectEffect = Fx.casing1;
                mirror = true;
                rotate = false;
                bullet = new BasicBulletType(5f, 25){{
                    inaccuracy = 4f;
                    width = 7f;
                    height = 9f;
                    lifetime = 64f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    ammoMultiplier = 1;
                }};
            }});
            weapons.add(new Weapon("b919-sfwar-debug-missile"){{
                reload = 40f;
                y = -3.5f;
                x = 11f;
                rotate = false;
                shake = 1f;
                shootCone = 10f;
                shoot.shots = 2;
                inaccuracy = 5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.shootMissileLong;

                bullet = new MissileBulletType(6f, 48){{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    scaleKeepVelocity = true;
                    splashDamageRadius = 45f;
                    splashDamage = 150f;
                    lifetime = 50f;
                    trailColor = Pal.unitBack;
                    backColor = Pal.unitBack;
                    frontColor = Pal.unitFront;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 6f;
                    weaveMag = 1f;
                }};
            }});
        }};
        spriteTest = new UnitType("sprite-test"){{
            // how big can units be?
            flying = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 1.5f;
            health = 1000*1000;
            armor = 1000*1000;
            engineSize = 1.8f;
            engineOffset = 5.7f;
            range = 50f;
            isEnemy = false;
            controlSelectGlobal = false;
            wreckSoundVolume = deathSoundVolume = 0.7f;

            mineTier = 1;
            mineSpeed = 2.5f;
        }};
    }
}
