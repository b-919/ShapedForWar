package b919.SFWar.content.units;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.MinerAI;
import mindustry.ai.types.RepairAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.type.Weapon;
import mindustry.type.weapons.*;

import static mindustry.Vars.tilesize;

public class NebulaeUnits {

    public static UnitType
    blackWasp, unstableDustMass, serpensMundi;
    public static void load(){
        blackWasp = new UnitType("black-wasp"){{
            coreUnitDock = true;
            //controller = u -> new BuilderAI(true, coreFleeRange); - I commented this out, is how the unit is controlled by AI
            isEnemy = false;
            envDisabled = 0;
            constructor = UnitEntity::create;
            range = 100f;
            faceTarget = true;
            targetPriority = -2;
            lowAltitude = false;
            mineWalls = true;
            mineFloor = true;
            mineHardnessScaling = false;
            flying = true;
            mineSpeed = 10f;
            mineTier = 6;
            buildSpeed = 5f;
            drag = 0.16f;
            speed = 7f;
            rotateSpeed = 8f;
            accel = 0.08f;
            itemCapacity = 180;
            health = 1500f;
            armor = 10f;
            hitSize = 12f;
            buildBeamOffset = 8f;
            payloadCapacity = 3f * 3f * tilesize * tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            fogRadius = 0f;
            targetable = false;
            hittable = false;


            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.31f;
                reload = 20f;
                x = 0f;
                y = 0f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                aimDst = 0f;
                shootCone = 40f;
                mirror = false;

                repairSpeed = 4.2f;
                fractionRepairSpeed = 0.03f;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Color.valueOf("bf92f9");
                healColor = Color.valueOf("bf92f9");

                bullet = new BulletType(){{
                    maxRange = 100;
                }};
            }});
        }};
        unstableDustMass = new UnitType("unstable-dust-mass"){{
            //controller = u -> new BuilderAI(true, coreFleeRange); - I commented this out, is how the unit is controlled by AI
            constructor = UnitEntity::create;
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
            flying = true;
            health = 50;
            hitSize = 9;
            itemCapacity = 10;
            omniMovement = true;
            rotateSpeed = 5f;
            createWreck = false;

            weapons.add(new Weapon(){{
                shootOnDeath = true;
                targetUnderBlocks = false;
                reload = 24f;
                shootCone = 270f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosionCrawler;
                shootSoundVolume = 0.4f;
                x = shootY = 0f;
                mirror = false;
                bullet = new BulletType(){{
                    collidesTiles = false;
                    collides = false;

                    rangeOverride = 35f;
                    hitEffect = Fx.pulverize;
                    speed = 0f;
                    splashDamageRadius = 75f;
                    instantDisappear = true;
                    splashDamage = 170f;
                    buildingDamageMultiplier = 0.68f;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                }};
            }});
        }};
    }
}
