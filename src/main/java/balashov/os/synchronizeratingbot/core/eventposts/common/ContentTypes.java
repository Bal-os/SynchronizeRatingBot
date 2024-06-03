package balashov.os.synchronizeratingbot.core.eventposts.common;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.ContentType;

public enum ContentTypes implements ContentType {
    DIGEST {
        @Override
        public ContentType getType() {
            return DIGEST;
        }
    },
    EVENT_POST {
        @Override
        public ContentType getType() {
            return EVENT_POST;
        }
    }
}
