/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.polyworld.distribution;

import org.terasology.math.geom.Vector2f;

/**
 * A distribution that looks like Amit's blob (star-shape)
 * @author Martin Steiger
 */
public class AmitBlobDistribution implements Distribution {

    @Override
    public boolean isInside(Vector2f p2) {
        Vector2f p = new Vector2f(2 * (p2.getX() - 0.5f), 2 * (p2.getY() - 0.5f));

        boolean eye1 = new Vector2f(p.getX() - 0.2f, p.getY() / 2 + 0.2f).length() < 0.05f;
        boolean eye2 = new Vector2f(p.getX() + 0.2f, p.getY() / 2 + 0.2f).length() < 0.05f;
        boolean body = p.length() < 0.8 - 0.18 * Math.sin(5 * Math.atan2(p.getY(), p.getX()));
        return !(body && !eye1 && !eye2);
    }
}
