/*
 * This file is part of Baritone.
 *
 * Baritone is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Baritone is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Baritone.  If not, see <https://www.gnu.org/licenses/>.
 */

package baritone.api;

import baritone.api.cache.IWorldScanner;
import net.minecraft.client.entity.EntityPlayerSP;

import java.util.List;

/**
 * @author Leijurv
 */
public interface IBaritoneProvider {

    /**
     * Returns the primary {@link IBaritone} instance. This instance is persistent, and
     * is represented by the local player that is created by the game itself, not a "bot"
     * player through Baritone.
     *
     * @return The primary {@link IBaritone} instance.
     */
    IBaritone getPrimaryBaritone();

    /**
     * Returns all of the active {@link IBaritone} instances. This includes the local one
     * returned by {@link #getPrimaryBaritone()}.
     *
     * @see #getBaritoneForPlayer(EntityPlayerSP)
     *
     * @return All active {@link IBaritone} instances.
     */
    List<IBaritone> getAllBaritones();

    /**
     * Provides the {@link IBaritone} instance for a given {@link EntityPlayerSP}. This will likely be
     * replaced with {@code #getBaritoneForUser(IBaritoneUser)} when {@code bot-system} is merged.
     *
     * @param player The player
     * @return The {@link IBaritone} instance.
     */
    IBaritone getBaritoneForPlayer(EntityPlayerSP player);

    /**
     * Returns the {@link IWorldScanner} instance. This is not a type returned by
     * {@link IBaritone} implementation, because it is not linked with {@link IBaritone}.
     *
     * @return The {@link IWorldScanner} instance.
     */
    IWorldScanner getWorldScanner();
}
