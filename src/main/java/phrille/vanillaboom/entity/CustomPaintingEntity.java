package phrille.vanillaboom.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;
import phrille.vanillaboom.init.ModEntities;
import phrille.vanillaboom.init.ModItems;

public class CustomPaintingEntity extends PaintingEntity implements IEntityAdditionalSpawnData
{
    public CustomPaintingEntity(EntityType<? extends CustomPaintingEntity> type, World world)
    {
        super(type, world);
    }

    public CustomPaintingEntity(World world, BlockPos pos, Direction facing)
    {
        super(world, pos, facing);
    }

    public void updateArt(PaintingType paintingType, Direction facing)
    {
        art = paintingType;
        updateFacingWithBoundingBox(facing);
    }

    @Override
    public void onBroken(@Nullable Entity brokenEntity)
    {
        if (world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS))
        {
            playSound(SoundEvents.ENTITY_PAINTING_BREAK, 1.0F, 1.0F);

            if (brokenEntity instanceof PlayerEntity)
            {
                PlayerEntity playerentity = (PlayerEntity) brokenEntity;

                if (playerentity.abilities.isCreativeMode)
                {
                    return;
                }
            }

            entityDropItem(getDrop());
        }
    }

    @Override
    public EntityType<?> getType()
    {
        return ModEntities.CUSTOM_PAINTING;
    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer)
    {
        buffer.writeString(Registry.MOTIVE.getKey(art).toString());
        buffer.writeByte((byte) facingDirection.getHorizontalIndex());
        buffer.writeInt(getHangingPosition().getX());
        buffer.writeInt(getHangingPosition().getY());
        buffer.writeInt(getHangingPosition().getZ());
    }

    @Override
    public void readSpawnData(PacketBuffer additionalData)
    {
        art = Registry.MOTIVE.getOrDefault(ResourceLocation.tryCreate(additionalData.readString()));
        facingDirection = Direction.byHorizontalIndex(additionalData.readByte());
        hangingPosition = new BlockPos(additionalData.readInt(), additionalData.readInt(), additionalData.readInt());
        updateFacingWithBoundingBox(facingDirection);
    }
    
    public Item getDrop()
    {
        if (art == PaintingType.ALBAN) 
        {
            return ModItems.ALBAN_PAINTING;
        }
        else if (art == PaintingType.AZTEC) 
        {
            return ModItems.AZTEC_PAINTING;
        }
        else if (art == PaintingType.AZTEC2) 
        {
            return ModItems.AZTEC2_PAINTING;
        }
        else if (art == PaintingType.BOMB) 
        {
            return ModItems.BOMB_PAINTING;
        }
        else if (art == PaintingType.BURNING_SKULL) 
        {
            return ModItems.BURNING_SKULL_PAINTING;
        }
        else if (art == PaintingType.BUST) 
        {
            return ModItems.BUST_PAINTING;
        }
        else if (art == PaintingType.COURBET) 
        {
            return ModItems.COURBET_PAINTING;
        }
        else if (art == PaintingType.CREEBET) 
        {
            return ModItems.CREEBET_PAINTING;
        }
        else if (art == PaintingType.DONKEY_KONG) 
        {
            return ModItems.DONKEY_KONG_PAINTING;
        }
        else if (art == PaintingType.FIGHTERS) 
        {
            return ModItems.FIGHTERS_PAINTING;
        }
        else if (art == PaintingType.GRAHAM) 
        {
            return ModItems.GRAHAM_PAINTING;
        }
        else if (art == PaintingType.KEBAB) 
        {
            return ModItems.KEBAB_PAINTING;
        }
        else if (art == PaintingType.MATCH) 
        {
            return ModItems.MATCH_PAINTING;
        }
        else if (art == PaintingType.PIGSCENE) 
        {
            return ModItems.PIGSCENE_PAINTING;
        }
        else if (art == PaintingType.PLANT) 
        {
            return ModItems.PLANT_PAINTING;
        }
        else if (art == PaintingType.POINTER) 
        {
            return ModItems.POINTER_PAINTING;
        }
        else if (art == PaintingType.POOL) 
        {
            return ModItems.POOL_PAINTING;
        }
        else if (art == PaintingType.SEA) 
        {
            return ModItems.SEA_PAINTING;
        }
        else if (art == PaintingType.SKELETON) 
        {
            return ModItems.SKELETON_PAINTING;
        }
        else if (art == PaintingType.SKULL_AND_ROSES) 
        {
            return ModItems.SKULL_AND_ROSES_PAINTING;
        }
        else if (art == PaintingType.STAGE) 
        {
            return ModItems.STAGE_PAINTING;
        }
        else if (art == PaintingType.SUNSET) 
        {
            return ModItems.SUNSET_PAINTING;
        }
        else if (art == PaintingType.VOID) 
        {
            return ModItems.VOID_PAINTING;
        }
        else if (art == PaintingType.WANDERER) 
        {
            return ModItems.WANDERER_PAINTING;
        }
        else if (art == PaintingType.WASTELAND) 
        {
            return ModItems.WASTELAND_PAINTING;
        }
        else if (art == PaintingType.WITHER) 
        {
            return ModItems.WITHER_PAINTING;
        }
        
        return null;
    }
}
